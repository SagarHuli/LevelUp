package graphs.DisjointSetUnion;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSetV2 dsu = new DisjointSetV2(accounts.size());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<accounts.size();i++) {
            List<String> account = accounts.get(i);
            for(int j=1; j<account.size(); j++) {
                if(!map.containsKey(account.get(j))) {
                    map.put(account.get(j), i);
                } else {
                    dsu.findByUnionByRank(i, map.get(account.get(j)));
                }
            }
        }
        List<List<String>> result = new LinkedList<>();
        ArrayList<String>[] mergedMail = new ArrayList[accounts.size()];
        for(int i=0; i<accounts.size(); i++) {
            mergedMail[i] = new ArrayList<>();
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int idx = dsu.findUltimateParent(entry.getValue());
            String mail = entry.getKey();
            mergedMail[idx].add(mail);
        }

        for(int i=0; i<accounts.size(); i++) {
            if(mergedMail[i].size() ==0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String str : mergedMail[i]) {
                temp.add(str);
            }
            result.add(temp);
        }
        return result;
    }
}
