package brg.utils.jhy.brggo.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import brg.utils.jhy.brggo.R;
import brg.utils.jhy.brggo.data.Hotels;

/**
 * Created by hayoung on 2018. 9. 10..
 * gkduduu@naver.com
 */
public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {
    Context context;
    List<Hotels> items;

    public SearchListAdapter(Context context, List<Hotels> items) {
        this.context = context;
        this.items = items;
    }

    public void updateData(List<Hotels> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Hotels item = items.get(position);
//        Drawable drawable = ContextCompat.getDrawable(context, item.getImage());
//        holder.image.setBackground(drawable);
        holder.name.setText(item.getNAME());
//        holder.cardview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.SEARCH_NAME);
        }
    }

}
