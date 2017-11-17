/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statistics;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 *
 * @author prokopiukd
 */
@Named
public class BlockchainService implements Serializable {

    private final static int AVG_TIME = 10;
    private Random random;
    private Map<String, Float> blockMap;
    private int index;
    
    //@PostConstruct
    public BlockchainService() {
        random = new Random();
        blockMap = new LinkedHashMap<>();
        while(blockMap.size()<10){
            makeBlock();
        }
    }
    
    public void makeBlock(){
        float time = random.nextInt(10000);
        blockMap.put("B"+index++, (time)/AVG_TIME);
    }
    
    public Map<String, Float> getBlocks(){
        return blockMap;        
    }
}
