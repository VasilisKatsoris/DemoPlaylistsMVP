package spotify.playlists.view.adapters.baseadapter;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClickableViewHolder<Data> extends RecyclerView.ViewHolder {
    private int position;
    Data data;
    View v;

    public ClickableViewHolder(@NonNull View v, ClickableRecyclerViewAdapter adapter) {
        super(v);
        this.v = v;
        if(adapter!=null && adapter.getRecyclerViewClickListener()!=null) {
            final RecyclerViewClickListener onItemClickListener = adapter.getRecyclerViewClickListener();
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClicked(data, position);
                    }
                }
            });
        }
    }


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    void setPosition(int position) {
        this.position = position;
    }

    public <T extends View> T findViewById(@IdRes int idRes){
        return v.findViewById(idRes);
    }

}
