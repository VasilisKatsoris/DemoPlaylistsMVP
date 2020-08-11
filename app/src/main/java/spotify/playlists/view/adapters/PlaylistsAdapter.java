package spotify.playlists.view.adapters;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;

import spotify.playlists.R;
import spotify.playlists.model.localdaos.Playlist;
import spotify.playlists.view.adapters.baseadapter.ClickableRecyclerViewAdapter;
import spotify.playlists.view.adapters.baseadapter.ClickableViewHolder;
import spotify.playlists.view.adapters.baseadapter.RecyclerViewClickListener;
import spotify.playlists.view.glide.GlideApp;
import spotify.playlists.view.glide.PlaylistCoverModel;


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


        GlideApp.with(holder.coverImg)
                .load(new PlaylistCoverModel().setMediaId(playlist.getPlaylistId()))
                .transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(R.drawable.record)
                .error(R.drawable.record)
                .into(holder.coverImg);

    }

    public static class PlaylistViewHolder extends ClickableViewHolder<Playlist> {
        TextView playlistNameTv;
        ImageView coverImg;

        PlaylistViewHolder(View view, ClickableRecyclerViewAdapter adapter) {
            super(view, adapter);
            playlistNameTv = view.findViewById(R.id.row_playlist_playlistNameTv);
            coverImg = view.findViewById(R.id.row_playlists_view_cover_img);
        }
    }
}

