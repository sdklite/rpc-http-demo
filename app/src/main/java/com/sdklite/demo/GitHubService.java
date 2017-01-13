package com.sdklite.demo;

import com.sdklite.gson.GsonDeserializer;
import com.sdklite.io.annotation.Deserialization;
import com.sdklite.rpc.RpcService;
import com.sdklite.rpc.annotation.Path;
import com.sdklite.rpc.annotation.PathParameter;
import com.sdklite.rpc.http.annotation.Get;

import java.util.List;

/**
 * Created by johnson on 13/1/2017.
 */
public interface GitHubService extends RpcService {

    @Get
    @Path("/users/{username}/repos")
    @Deserialization(GsonDeserializer.class)
    void getRepositories(@PathParameter("username") final String username, final RpcService.Callback<List<?>> callback);

}
