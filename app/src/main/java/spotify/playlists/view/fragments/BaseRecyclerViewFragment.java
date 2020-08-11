package spotify.playlists.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import spotify.playlists.R;
import spotify.playlists.presenter.presenters.BasePresenter;
import spotify.playlists.util.AnimationUtils;
import spotify.playlists.view.adapters.baseadapter.ClickableRecyclerViewAdapter;
import spotify.playlists.presenter.presenters.interfaces.BaseViewInterface;

public abstract class BaseRecyclerViewFragment<Presenter extends BasePresenter, Adapter extends ClickableRecyclerViewAdapter>
        extends PresenterFragment<Presenter>
        implements SwipeRefreshLayout.OnRefreshListener, BaseViewInterface {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;
    TextView noResultsTv;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        recyclerView = v.findViewById(R.id.fragment_recycler_view_recycler_view);
        progressBar = v.findViewById(R.id.fragment_recycler_view_progress_bar);
        noResultsTv = v.findViewById(R.id.fragment_recycler_view_no_results_tv);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(gridLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                gridLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        swipeRefreshLayout = v.findViewById(R.id.fragment_recycler_view_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        return v;
    }

    public void showNoResultsView(boolean visible){
        noResultsTv.setVisibility(visible?View.VISIBLE:View.GONE);
    }

    void addHeader(View headerView){
        FrameLayout header = getView().findViewById(R.id.fragment_recycler_view_header_layout);
        header.addView(headerView);
    }

    void fadeProgressBar(final boolean visible){
        AlphaAnimation alphaAnimation = new AlphaAnimation(visible ? 0:1,visible?1:0);
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(new AnimationUtils.AnimationInterface(){
            @Override
            public void onAnimationEnd(Animation animation) {
                progressBar.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        progressBar.startAnimation(alphaAnimation);
    }

    void animateRecyclerViewWhenLayoutIsReady(){
        recyclerView.setVisibility(View.INVISIBLE);
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                recyclerView.setVisibility(View.VISIBLE);
                LinearLayoutManager gridLayoutManager = ((LinearLayoutManager)recyclerView.getLayoutManager());
                if(gridLayoutManager==null){
                    return;
                }
                int visibleChilds = gridLayoutManager.findLastVisibleItemPosition() - gridLayoutManager.findFirstVisibleItemPosition() + 1;

                long stepDelay = 50;

                for (int i = 0; i < visibleChilds; i++) {
                    final View v = recyclerView.getChildAt(i);
                    if(v == null){
                        continue;
                    }
                    AnimationSet set = new AnimationSet(true);
                    Animation translateAnim = AnimationUtils.getRightToLeftAnimation(Animation.RELATIVE_TO_PARENT);
                    set.addAnimation(new AlphaAnimation(-8, 1));
                    set.addAnimation(translateAnim);
                    set.setStartOffset(i * stepDelay);
                    set.setDuration(400);
                    set.setInterpolator(new DecelerateInterpolator(2.5f));
                    v.startAnimation(set);
                }
            }
        });

    }

    @Override
    public void onRefresh() {

    }

    Adapter getAdapter(){
        return (Adapter) recyclerView.getAdapter();
    }

    public void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }
    public void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }

    public void notifyDataSetChanged(){
        if(getAdapter()!=null){
            getAdapter().notifyDataSetChanged();
        }
    }

    public void setRecyclerAdapter(ClickableRecyclerViewAdapter adapter){
        if(adapter!=null && recyclerView!=null){
            recyclerView.setAdapter(adapter);
        }
    }
}
