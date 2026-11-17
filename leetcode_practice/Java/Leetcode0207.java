class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> set = new HashSet<Integer>();
        Map<Integer, ArrayList<Integer>>map = new HashMap<>();
        Map<Integer, Integer> prePerCourse = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            set.add(i);
            map.put(i, new ArrayList<>());
        }

        int numOfPairs = prerequisites.length;

        for(int[] pair: prerequisites){
            set.remove(pair[1]);
            ArrayList<Integer> lst = map.getOrDefault(pair[0], new ArrayList<>());
            lst.add(pair[1]);
            map.put(pair[0], lst);
            prePerCourse.put(pair[1], prePerCourse.getOrDefault(pair[1], 0) + 1);
        }

        Queue<Integer> processed = new LinkedList<>();

        for(int i: set){
            processed.add(i);
        }

        while(!processed.isEmpty()){
            for(int len = processed.size(); len > 0; len--){
                ArrayList<Integer> lst = map.get(processed.poll());
                for(int i: lst){
                    prePerCourse.put(i, prePerCourse.get(i)-1);
                    numOfPairs -- ;
                    if(prePerCourse.get(i) == 0){
                        prePerCourse.remove(i);
                        processed.add(i);
                    }
                }
            }
        }

        return numOfPairs == 0;


    }
}