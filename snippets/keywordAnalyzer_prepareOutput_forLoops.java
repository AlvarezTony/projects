************** KeywordAnalyzer -- WORKING (somewhat) ***************************************

public void prepareOutput() {
        
        Integer maxLength = 20;
        
        for (Map.Entry<String, List<Integer>> entry : keywordMap.entrySet()) {
            
            System.out.print("\n" + entry.getKey() + "= \n" + "[");
            
            Integer currentLength = 0;
            
            for(Integer value : entry.getValue()) {
                currentLength++;

                
                if(currentLength < maxLength) {
                    
                System.out.print(value + ", ");
            } else {
                System.out.print(value + "]\n");
            }   
        }
        //System.out.print("] \n");
      
    }
        System.out.print("]");
    }