# [Unrated] Connectivity Potential - 14538 

[문제 링크](https://www.acmicpc.net/problem/14538) 

### 성능 요약

메모리: 115220 KB, 시간: 144 ms

### 분류

플로이드–워셜, 그래프 이론

### 문제 설명

<p>Space elevator and shuttle (SES) systems have been setup high above the earth, each involving a number of stations. Stations that are required to deliver high frequency transit are connected directly, while some others are connected via another station in the system.  If a space traveller has to travel from one station to another that is not directly connected, then he/ she will be directed through a route with minimum number of hops necessary to reach the destination.</p>

<p>The figure below shows a SES system involving four stations, where the directed arcs indicate the immediate connections between a pair of stations.  It can be seen that Station 1 is directly connected to Station 2 and Station 4, and it is indirectly connected to Station 3 via Station 2.  In this example, the longest route between any two stations is 3 hops, and there are two such routes in the system, i.e., from stations 2 to 4, and from stations 4 to 1.</p>

<p style="text-align: center;"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14538/1.png" style="height:153px; width:321px"></p>

<p>A SES system’s connectivity potential is calculated as the product of the number of hops in the longest route and the occurrence of routes with that many hops in the system.  Therefore, the connectivity potential of the SES system shown in the figure above is 3 * 2 = 6.</p>

<p><!--![endif]----></p>

### 입력 

 <p>The first line has a positive integer <strong>T</strong>, (1 <= <strong>T</strong> <= 1000), denoting the number of test cases. The test cases are given in the following lines.  Each test case describes a SES system, which starts on a new line with a positive integer <strong>S </strong>(1 <= <strong>S </strong><= 40) indicating the number of stations.  The next <strong>S </strong>lines delineate the connections between stations containing either a 1 or a 0, where 1 indicates a direct connection exists from the station on row <strong>i </strong>to the station on column <strong>j</strong>, and a 0 if there is no direct connection.</p>

### 출력 

 <p>For each test case, produce a single line of output that starts with the prefix “Case #x:” where x represents the case number (starting from one and incrementing at each new test case), followed by a single space, and then the results, i.e., the connectivity potential of the SES system.</p>

