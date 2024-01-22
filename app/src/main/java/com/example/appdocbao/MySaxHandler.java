package com.example.appdocbao;

import com.example.appdocbao.model.Item;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MySaxHandler extends DefaultHandler {
    private final List<Item>list;
    private Item item;
    private String temp;
    private boolean flagstart=false;


    public MySaxHandler() {
        list=new ArrayList<>();
    }

    public  List<Item> getItems(){
        return list;
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if(flagstart){
            temp=new String(ch,start,length);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equalsIgnoreCase("item")){
            item=new Item();
            flagstart=true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equalsIgnoreCase("item")){
            list.add(item);

        }else if(qName.equalsIgnoreCase("title")){
            item.setTitle(temp);
        }if(qName.equalsIgnoreCase("description")){
            item.setDescription(temp);
        }if(qName.equalsIgnoreCase("pubDate")){
            item.setPubDate(temp);
        }if(qName.equalsIgnoreCase("link")){
            item.setLink(temp);
        }
    }
}
