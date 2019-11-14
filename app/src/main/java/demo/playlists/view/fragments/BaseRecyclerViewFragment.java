package demo.playlists.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import demo.playlists.R;
import demo.playlists.presenter.presenters.BasePresenter;
import demo.playlists.util.AnimationUtils;
import demo.playlists.view.adapters.baseadapter.ClickableRecyclerViewAdapter;
import demo.playlists.view.interfaces.BaseViewInterface;

public abstract class BaseRecyclerViewFragment<Presenter extends BasePresenter, Adapter extends ClickableRecyclerViewAdapter> extends PresenterFragment<Presenter> implements SwipeRefreshLayout.OnRefreshListener,
        BaseViewInterface {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_playlists, container, false);
        recyclerView = v.findViewById(R.id.fragment_playlists_recycler_view);
        progressBar = v.findViewById(R.id.fragment_playlists_progress_bar);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(gridLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                gridLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        swipeRefreshLayout = v.findViewById(R.id.fragment_playlists_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        return v;
    }

    void fadeOutProgressBar(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(new AnimationUtils.AnimationInterface(){
            @Override
            public void onAnimationEnd(Animation animation) {
                progressBar.setVisibility(View.GONE);
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
