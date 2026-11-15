class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] postOf = new ArrayList[numCourses];
        int[] preNeeded = new int[numCourses];
        int totalPair = prerequisites.length;
        List<Integer> order = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            postOf[i] = (new ArrayList<>());
        }


        for(int[] pair: prerequisites){
            preNeeded[pair[0]] ++;
            postOf[pair[1]].add(pair[0]);
        }


        Queue <Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(preNeeded[i] == 0){
                queue.add(i);
                order.add(i);
            }
        }

        while(!queue.isEmpty()){
            for(int len = queue.size(); len > 0; len--){
                List<Integer> lst = postOf[queue.poll()];
                for(int i: lst){
                    totalPair--;
                    preNeeded[i] --;
                    if(preNeeded[i] == 0){
                        queue.add(i);
                        order.add(i);
                    }
                }
            }
        }

        if(totalPair == 0){
            return order.stream().mapToInt(Integer::intValue).toArray();
        }
        else{
            return new int[0];
        }
    }
}