package fly.tlf.controller;


import fly.tlf.model.Data;
import fly.tlf.view.LiveBar;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;

import java.io.IOException;

public class UpdateTwitchRecords implements Runnable{


    private RestClient restClient;
    private int TicksToWait = 5000;
    private int CurrentTick = 5000;

    public UpdateTwitchRecords()
    {

        HttpHost host = new HttpHost("api.twitch.tv",443,"https");
        Header h = new Header() {
            @Override
            public String getName() {
                return "Client-ID";
            }

            @Override
            public String getValue() {
                return "3f2o46y0xr1x0xbwwcnvu7oethgq89";
            }

            @Override
            public HeaderElement[] getElements() throws ParseException {
                return new HeaderElement[0];
            }
        };
        restClient = RestClient.builder(host).setDefaultHeaders(new Header[]{h}).build();
    }

    @Override
    public void run() {

        if(CurrentTick < TicksToWait)
        {

            ++CurrentTick;
            return;
        }
        CurrentTick = 0;
        try {
            for (String name:Data.streamers.streamerNames)
            {
                JSONObject root = new JSONObject(EntityUtils.toString(restClient .performRequest("GET","https://api.twitch.tv/kraken/streams/"+name+"/").getEntity()));
                LiveBar lb = new LiveBar(!root.get("stream").toString().equals("null"),"https://www.twitch.tv/"+name);
                Data.mainWindow.addLiveBar(lb,!root.get("stream").toString().equals("null"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
