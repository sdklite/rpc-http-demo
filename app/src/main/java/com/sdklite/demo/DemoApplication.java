package com.sdklite.demo;

import android.app.Application;
import android.util.Log;

import com.sdklite.rpc.RpcException;
import com.sdklite.rpc.RpcService;
import com.sdklite.rpc.RpcServiceFactory;

import java.util.List;

/**
 * Created by johnson on 13/1/2017.
 */
public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        final RpcServiceFactory factory = new RpcServiceFactory();
        final GitHubService github = factory.newRpcService(GitHubService.class, "https://api.github.com");
        github.getRepositories("johnsonlee", new RpcService.Callback<List<?>>() {
            @Override
            public void onSuccess(final List<?> result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(final RpcException e) {
                Log.e("Demo", e.getMessage(), e);
            }
        });

    }

}
