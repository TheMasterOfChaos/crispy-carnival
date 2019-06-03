package com.example.testname.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.testname.R;
import com.example.testname.adapters.OffersAdapter;
import com.example.testname.specialClasses.Order;
import com.example.testname.specialClasses.Server;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class OffersFragment extends Fragment {


  public List<Order> orderList;
  OffersAdapter adapter;
  SwipeRefreshLayout refreshLayout;




  public OffersFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    orderList = new ArrayList<>();
    // Inflate the layout for this fragment

    update();

    return inflater.inflate(R.layout.fragment_offers, container, false);
  }

  public void update() {
    Log.wtf("tag", "update: ");
    Call<List<Order>> getOrder = Server.api.getOrders(" Token "
            + getContext()
            .getSharedPreferences("user_data", MODE_PRIVATE).getString("token",""));
    getOrder.enqueue(new Callback<List<Order>>() {
      @Override
      public void onResponse(Call<List<Order>> call, @NonNull Response<List<Order>> response) {
        orderList.clear();
        for (Order order: response.body()) {
          if (order.getDriver() == null) {
            orderList.add(order);
          }
        }

        adapter.notifyDataSetChanged();
      }

      @Override
      public void onFailure(Call<List<Order>> call, Throwable t) {
        Toast.makeText(getContext(),"Нет сети",Toast.LENGTH_LONG).show();
        t.printStackTrace();
      }
    });

  }

  @Override
  public void onResume() {
    super.onResume();
    update();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    RecyclerView recyclerView = view.findViewById(R.id.offers_view);

    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    refreshLayout =  view.findViewById(R.id.refresh);
    refreshLayout.setColorSchemeResources(R.color.blueMiddle);
    refreshLayout.setOnRefreshListener(() -> {
      update();
      adapter.notifyDataSetChanged();
      refreshLayout.setRefreshing(false);
    });
    adapter = new OffersAdapter(orderList);

    recyclerView.setAdapter(adapter);
  }


}
