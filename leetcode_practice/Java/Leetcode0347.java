class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }


        for(int key: map.keySet()){
            int val = map.get(key);
            if(bucket[val] == null){
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }

        int [] arr = new int[k];
        int index = 0;
        for(int i = nums.length; i >= 0 ; i--){
            if(bucket[i] != null){
                for(int key: bucket[i]){
                    if(index < k){
                        arr[index] = key;
                        index++;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return arr;

        
    }
}