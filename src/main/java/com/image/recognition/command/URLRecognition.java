package com.image.recognition.command;

import com.alibaba.fastjson.JSON;
import com.image.recognition.bean.RecognitionResult;
import com.image.recognition.exception.ExaDeepExceotion;
import com.image.recognition.tools.BuildHelper;
import com.image.recognition.tools.HttpHelper;

import java.io.IOException;
import java.util.List;

/**
 * Created by robert on 2015/8/9.
 */
public class URLRecognition extends BaseRecognition {

    URLRecognition() {
    }

    @Override
    public void prepare(List<String> paths) throws ExaDeepExceotion {
        if (null == paths || paths.isEmpty())
            throw new ExaDeepExceotion("please input ULR.");
        for (String path : paths)
            if (!BuildHelper.rexHttpURL(path))
                throw new ExaDeepExceotion("someone of your paths is illegal.");

        this.setUrlPath(BuildHelper.getValue("HTTP.URL.ISPORN"));

        this.setParams(paths);
    }

    @Override
    public RecognitionResult execute() {
        if (getParams() instanceof List) ;
        {
                HttpHelper.HttpResult httpResult = null;
                try {
                    httpResult = HttpHelper.httpRequestURL(getUrlPath(), (List<String>) getParams());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    RecognitionResult recognitionResult = JSON.parseObject(httpResult.content, RecognitionResult.class);

                    return recognitionResult;
                }catch (Exception e){
                    e.printStackTrace();
                }

        }

        return null;
    }
}
