package com.example.chiakimayuzumi.slidebackrefresh;

import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chiakimayuzumi.slidebackrefresh.view.PullRecycler;


/**
 * Created by chiakimayuzumi on 16/5/27.
 */
public class ListDemoActivity extends BaseListActivity {
  private Handler handler = new Handler();
  //给不同的布局编号
  public static final int VIEW_TYPE_TEXT = 6;
  public static final int VIEW_TYPE_HEADER = 7;

  @Override
  protected void setUpContentView() {
    //初始化你自己的布局
    setContentView(R.layout.activity_test);
  }

  @Override
  protected void setUpView() {
    //初始化 recycler，不用改
    recycler = (PullRecycler) findViewById(R.id.pullRecycler);
    setUpToolbar(R.string.test);

  }

  @Override
  protected void setUpData() {
    //不用改
    super.setUpData();
    adapter.setIsHeaderShown(true);
    recycler.setRefreshing();

  }

  @Override
  protected int getItemType(int position) {

   // if (position == 0){

     // return VIEW_TYPE_HEADER;
    //}else {
      return VIEW_TYPE_TEXT;
    //}

  }

  @Override
  protected BaseViewHolder getNormalViewHolder(ViewGroup parent, int viewType) {
    //返回不同的布局
    if(viewType == VIEW_TYPE_HEADER){
     // View onlytextview = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_top_layout, parent, false);
     // return new HeaderViewHolder(onlytextview);
    }else {
      View onlytextview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
      return new TextViewHolder(onlytextview);
    }
    return null;
  }

  @Override
  public void onRefresh(int action) {
    //这里写上刷新逻辑，参考如下：

        /*
            recycler.enableLoadMore(true);//允许加载更多

            //如果是上拉加载，执行什么操作
    if (action == PullRecycler.ACTION_LOAD_MORE_REFRESH){

      handler.postDelayed(new Runnable() {
        @Override
        public void run() {

          //通过加载是否成功,改变mCurrentState，并且改变 footer 显示信息

          adapter.notifyDataSetChanged();
          recycler.onRefreshCompleted();

          Log.d("test", "上拉加载>>>>>>>>>>>>>>>>>>>>>");

        }
      }, 1000);

    }
    */


    //如果是下拉刷新，执行什么操作
    if (action == PullRecycler.ACTION_PULL_TO_REFRESH){

      adapter.onLoadMoreStateChanged(false);
      adapter.notifyDataSetChanged();
      handler.postDelayed(new Runnable() {
        @Override
        public void run() {

        //业务
          Log.d("Tag","刷新业务");

          adapter.notifyDataSetChanged();
          recycler.onRefreshCompleted();
        }
      }, 1000);
    }


  }


  //在这里给出你需要布局的 ViewHolder，例如上面的 TextViewHolder 示例如下

    class TextViewHolder extends BaseViewHolder{

    //ImageView headimage;
    //ImageView seximage;
    //TextView nickname;
    //TextView datatime;
    //TextView blogcontent;
      TextView mTextView;

    public TextViewHolder(View itemView) {
      super(itemView);
      //nickname = (TextView) itemView.findViewById(R.id.nickname);
     // datatime = (TextView) itemView.findViewById(R.id.data_time);
     // blogcontent = (TextView) itemView.findViewById(R.id.blog_content);
      //headimage = (ImageView) itemView.findViewById(R.id.head_image);
      //seximage = (ImageView) itemView.findViewById(R.id.sex_image);
      mTextView = (TextView) itemView.findViewById(R.id.text);
    }

    @Override
    public void onBindViewHolder(int position) {


     // headimage.setImageResource(R.drawable.img);
      //seximage.setImageResource(R.drawable.community_boy);



      //nickname.setText("abai");
     // datatime.setText("2099-9-0");
     // blogcontent.setText("blblblblblblbbl");
      mTextView.setText("这里是测试");

    }

    @Override
    public void onItemClick(View view, int position) {



    }
  }



}
