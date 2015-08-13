package com.image.recognition.command;

import com.image.recognition.bean.RequestType;

/**
 * Created by robert on 2015/8/5.
 */
public class RecognitionFactory {

    public static BaseRecognition getRecognition(RequestType requestType) {
        switch (requestType) {
            //HTTP��ַģʽ
            case URL:
                return new URLRecognition();
            //�����ļ�ģʽ
            case RESOURCES:
                return new FileRecognition();
            default:
                break;
        }

        return null;
    }
}
