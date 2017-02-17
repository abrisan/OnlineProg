from collections import Counter

str = raw_input()
mp = Counter(str)

freqs = sorted([v for k,v in mp.iteritems()])
freq_dist = dict(Counter(freqs))
if len(freq_dist) == 1:
    print "YES"
elif len(freq_dist) > 2:
    print "NO"
elif len(freq_dist) == 2:
    keys = [k for k,v in freq_dist.iteritems()]
    diff = keys[0] - keys[1]
    if keys[0] == 1 and freq_dist[keys[0]] == 1 :
        print "YES"
    elif keys[1] == 1 and freq_dist[keys[1]] == 1:
        print "YES"
    elif diff == 1 or diff == -1 and freq_dist[keys[0]] == 1 or freq_dist[keys[1]] == 1:
        print "YES"
    else:
        print "NO"


