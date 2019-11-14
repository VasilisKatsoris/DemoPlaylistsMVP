package demo.playlists.view.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import demo.playlists.R;
import demo.playlists.model.localdaos.Song;
import demo.playlists.view.adapters.baseadapter.ClickableRecyclerViewAdapter;
import demo.playlists.view.adapters.baseadapter.ClickableViewHolder;
import demo.playlists.view.adapters.baseadapter.RecyclerViewClickListener;

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

        Glide.with(holder.iconImg.getContext()).load(song.getImageUrl()).
                into(holder.iconImg);
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
