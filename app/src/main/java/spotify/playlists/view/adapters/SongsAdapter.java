package spotify.playlists.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;

import spotify.playlists.R;
import spotify.playlists.model.localdaos.Song;
import spotify.playlists.view.adapters.baseadapter.ClickableRecyclerViewAdapter;
import spotify.playlists.view.adapters.baseadapter.ClickableViewHolder;
import spotify.playlists.view.adapters.baseadapter.RecyclerViewClickListener;

public class SongsAdapter extends ClickableRecyclerViewAdapter<SongsAdapter.SongHolder, Song> {


    public SongsAdapter(ArrayList<Song> items, RecyclerViewClickListener<Song> onItemClickListener) {
        super(items, onItemClickListener);
    }

    @Override
    public SongHolder onViewHolderCreate(ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_song_view, parent, false);
        return new SongHolder(itemView, this);
    }

    @Override
    public void onViewHolderBind(SongHolder holder, Song data, int position) {
        Song song = getData().get(position);
        holder.artistTv.setText(song.getArtistName());
        holder.trackNameTv.setText(song.getTrackName());

        Glide.with(holder.iconImg.getContext())
                .load(song.getImageUrl())
                .placeholder(R.drawable.record)
                .error(R.drawable.record)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.iconImg);

    }


    public static class SongHolder extends ClickableViewHolder<Song> {
        TextView artistTv, trackNameTv;
        ImageView iconImg;
        SongHolder(@NonNull View view, ClickableRecyclerViewAdapter adapter) {
            super(view, adapter);
            artistTv = view.findViewById(R.id.row_song_artist_tv);
            trackNameTv = view.findViewById(R.id.row_song_name_tv);
            iconImg = view.findViewById(R.id.row_song_artwork_img);
        }
    }

}
