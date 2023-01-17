package com.example.singleselectionactivity.singleselection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singleselectionactivity.R;

import java.util.ArrayList;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.SingleViewHolder> {

    private Context context;
    private ArrayList<Employee> employees;
    private int checkedPosition = 0;// -1 no default selection  0: first item selected


    public SingleAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }

    public Employee getSelected() {
        if(checkedPosition != -1) {
            return employees.get(checkedPosition);
        }
        return  null;
    }

    class SingleViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public SingleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.emp_name);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(final Employee employee) {
            if(checkedPosition == -1 ) {
                imageView.setVisibility(View.GONE);
            } else {
                if(checkedPosition == getAdapterPosition()) {
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.GONE);
                }
            }

            textView.setText(employee.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemView.setVisibility(View.VISIBLE);

                    if(checkedPosition != getAdapterPosition() ) {
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                        notifyItemChanged(checkedPosition);
                    }
                }
            });
        }
    }


    @NonNull
    @Override
    public SingleAdapter.SingleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false);

        return new SingleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleAdapter.SingleViewHolder holder, int position) {

        holder.bind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
