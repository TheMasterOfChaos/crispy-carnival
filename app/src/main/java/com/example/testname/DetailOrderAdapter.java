import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.testname.specialClasses.Order;

import java.util.List;

public class DetailOrderAdapter extends RecyclerView.Adapter<DetailOrderAdapter.DetailsViewHolder> {

    List<Order> orderList;

    public DetailOrderAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder detailsViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {
        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
