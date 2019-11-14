package demo.playlists.view.adapters.baseadapter;

public interface RecyclerViewClickListener<DataClass> {
    void onItemClicked(DataClass data, int position);
}
