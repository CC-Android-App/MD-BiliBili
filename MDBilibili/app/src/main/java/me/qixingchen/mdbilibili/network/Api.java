package me.qixingchen.mdbilibili.network;

import me.qixingchen.mdbilibili.model.FeedbackM;
import me.qixingchen.mdbilibili.model.List;
import me.qixingchen.mdbilibili.model.RecommendM;
import me.qixingchen.mdbilibili.model.SearchM;
import me.qixingchen.mdbilibili.model.UserNameM;
import me.qixingchen.mdbilibili.model.UserUidM;
import me.qixingchen.mdbilibili.model.VideoM;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Farble on 2015/7/28 22.
 */
public interface Api {
    String URL = "http://api.bilibili.cn";
    String VIDEO_URL = "http://www.bilibili.com/";

    interface SearchApi {
        @GET("/search")
        Observable<SearchM> doSearch(@Query("keyword") String keyword, @Query("page") int page,
                                     @Query("pagesize") int pagesize, @Query("order") String order);
    }

    interface RecommendApi {

        @GET("/author_recommend")
        Call<RecommendM> getRecommendApi(@Query("aid") int aid);
    }

    interface FeedBackApi {

        @GET("/feedback")
        Observable<FeedbackM> getFeedBackApiApi(@Query("aid") int aid, @Query("ver") int ver);
    }

    interface UserInfoBynameApi {

        @GET("/userinfo")
        Observable<UserNameM> getUserInfoBynameApi(@Query("user") String user);
    }

    interface UserInfoByuidApi {

        @GET("/userinfo")
        Observable<UserUidM> getUserInfoByuidApi(@Query("uid") String uid);
    }

    interface VideoApi {

        @GET("/m/html5")
        Call<VideoM> getVideoApi(@Query("aid") String aid);

        @GET("/m/html5")
        Observable<VideoM> getVideoApiRx(@Query("aid") String aid);
    }

    interface ListApi {

        @GET("/list")
        Call<List> getList(
                @Query("tid") int tid,
                @Query("ver") int ver,
                @Query("pagesize") int pageSize
        );
    }
}
