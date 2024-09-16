class Solution:
    def findMinDifference(self, P: List[str]) -> int:
        return (m:=sorted(int(t[:2])*60+int(t[3:]) for t in P)) and min(b-a for a,b in pairwise(m+[m[0]+1440]))     