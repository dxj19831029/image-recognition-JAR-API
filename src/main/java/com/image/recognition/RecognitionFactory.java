package com.image.recognition;

import com.image.recognition.bean.RequestType;
import com.image.recognition.command.BaseRecognition;
import com.image.recognition.command.SingleRecognition;

/**
 * Created by robert on 2015/8/5.
 */
public class RecognitionFactory {

    public static BaseRecognition getRecognition(RequestType requestType) {
        switch (requestType) {
            //����ַģʽ
            case SINGLE:
                return new SingleRecognition();
            //���ַģʽ
            case LIST:
                break;
            //�����ļ�ģʽ
            case RESOURCES:
                break;
            default:
                break;
        }

        return null;
    }
}
