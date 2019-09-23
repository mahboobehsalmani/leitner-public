package msalmani.leitner;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public  class Box1Adapter extends RecyclerView.Adapter<Box1Adapter.CategoriesViewHolder> {

    private ArrayList<String> categoriesItems;

    public Box1Adapter (ArrayList categoriesItems){
        this.categoriesItems = categoriesItems;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.card_row, viewGroup, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder myViewHolder, int position) {
        myViewHolder.item.setText(categoriesItems.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    class CategoriesViewHolder extends  RecyclerView.ViewHolder {

        TextView item;

        CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.cardText);
        }
    }
}
