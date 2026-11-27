public static List<List<String>> topUsers(List<List<String>> records, int k) {
    // 1. 过滤 2024 + COMPLETED，同时按 user 累加
    // 2. 对 entry 排序：总额降序，名字升序
    // 3. 取前 k 个，转成 [user, total]
    Map<String, Integer> total = new HashMap<>();
    for (List<String> r : records) {
        if (!r.get(4).equals("COMPLETED") || !r.get(3).endsWith("-2024")) continue;
        total.merge(r.get(1), Integer.parseInt(r.get(2)), Integer::sum);
    }
    return total.entrySet().stream()
        .sorted(Solution::compareEntry)
        .limit(k)
        .map(e -> List.of(e.getKey(), String.valueOf(e.getValue())))
        .collect(Collectors.toList());
}

private static int compareEntry(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
    int c = Integer.compare(b.getValue(), a.getValue());   // 总额降序
    if (c != 0) return c;
    return a.getKey().compareTo(b.getKey());               // 名字升序
}