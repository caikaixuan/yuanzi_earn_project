package com.ygbc.brain.business.management.web.getQuesiton;

import com.alibaba.fastjson.JSONObject;
import com.ygbc.brain.business.management.api.dto.question.CreateQuestionReqDTO;
import com.ygbc.brain.common.utils.FileUtils;

import java.io.File;
import java.util.List;

public class GetQuestion {

    public static void main(String[] args) {
        File file = new File("/Users/kaixuan/Documents/yuanzi_earn/question_2.txt");
        try {
            List<String> lines = FileUtils.readLines(file);
            for (int i = 0;i < lines.size();i++) {
                String line = lines.get(i);
                if(line.contains("（") && line.contains("）")){
                    CreateQuestionReqDTO createQuestionReqDTO = new CreateQuestionReqDTO();
                    createQuestionReqDTO.setContent(getContent(line));
                    createQuestionReqDTO.setOptions(getOptions(line));
                    createQuestionReqDTO.setAnswer(getAnswer(line));
                    createQuestionReqDTO.setCurrentRate(0);
                    createQuestionReqDTO.setDifficulty(60);
                    createQuestionReqDTO.setType(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getContent(String line){
        int start = getFirstContentCharIndex(line);
        int stop = getContentLastChar(line);
        return line.substring(start+1,stop);

    }

    public static JSONObject getOptions(String line){
        JSONObject options = new JSONObject();
        if(line.contains("A")){
            options.put("A",getOption(line,"A","B").trim());
        }
        if(line.contains("B")){
            options.put("B",getOption(line,"B","C").trim());
        }
        if(line.contains("C")){
            options.put("C",getOption(line,"C","D").trim());
        }
        if(line.contains("D")){
            options.put("D",getOption(line,"D","（").trim());

        }
        return options;

    }

    public static String getAnswer(String line){
        int start = line.lastIndexOf("（");
        int stop = line.lastIndexOf("）");
        return line.substring(start+1,stop);
    }

    public static int getFirstContentCharIndex(String line){
        for(int i=0;i<line.length();i++){
            if(!Character.isDigit(line.charAt(i))){
                return i;
            }
        }
        return -1;
    }

    public static int getContentLastChar(String line){
        return line.indexOf("？")+1;
    }

    public static String getOption(String line,String start,String stop){
        int first = line.indexOf(start);
        int last = line.indexOf(stop);
        if(last < 0){
            last = line.lastIndexOf("（");
        }
//        System.out.println("----------getOption----------"+line+";first:"+first+";last:"+last);
        return line.substring(first,last);
    }
}
