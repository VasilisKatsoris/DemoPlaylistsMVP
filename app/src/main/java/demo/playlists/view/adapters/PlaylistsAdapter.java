package demo.playlists.view.adapters;

import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import demo.playlists.R;
import demo.playlists.model.localdaos.Playlist;
import demo.playlists.view.adapters.baseadapter.ClickableRecyclerViewAdapter;
import demo.playlists.view.adapters.baseadapter.ClickableViewHolder;
import demo.playlists.view.adapters.baseadapter.RecyclerViewClickListener;


public class PlaylistsAdapter extends ClickableRecyclerViewAdapter<PlaylistsAdapter.PlaylistViewHolder, Playlist> {


    public PlaylistsAdapter(ArrayList<Playlist> items, RecyclerViewClickListener<Playlist> onItemClickListener) {
        super(items, onItemClickListener);
    }

    @Override
    public PlaylistViewHolder onViewHolderCreate(ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_playlist_view, parent, false);

        return new PlaylistViewHolder(itemView, this);
    }

    @Override
    public void onViewHolderBind(PlaylistViewHolder holder, Playlist data, int position) {
        Playlist playlist = getData().get(position);
        String name = playlist.getName();
        String songsCount = "   ("+playlist.getItemCount()+")";
        Spannable spannable = new SpannableString(name+songsCount);
        int color = ContextCompat.getColor(holder.playlistNameTv.getContext(),R.color.colorAccent);
        spannable.setSpan(new ForegroundColorSpan(color), name.length(), name.length()+songsCount.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new RelativeSizeSpan(0.7f), name.length(), name.length()+songsCount.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        holder.playlistNameTv.setText(spannable);
    }

    public static class PlaylistViewHolder extends ClickableViewHolder<Playlist> {
        TextView playlistNameTv;
        PlaylistViewHolder(View view, ClickableRecyclerViewAdapter adapter) {
            super(view, adapter);
            playlistNameTv = (TextView) view;
        }
    }
}

