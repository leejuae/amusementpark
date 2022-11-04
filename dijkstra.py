import heapq
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한을 의미하는 값 1e9 = 10억

# 노드의 개수, 간선의 개수를 입력받기
n = 6 #시작구역(출발지) 포함해서 6개의 구역을 돌아다닐 예정
m = 720 #모든 노드에서 모든 노드로 이동할 수 있어야 함. 따라서 6! = 720
# 시작 노드 번호를 입력받기
start = 1 #물류센터의 출발점은 항상 1로 정해져있음.
# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만듦
graph=[[] for i in range(n+1)]
# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] *(n+1)


def dijkstra(start):
    #파일 읽어오기
    # 모든 간선 정보를 입력받기
    for a in range(m):
        a = b
        for b in range(m):
            c=map(int, input().split()) #파일 입출력으로 알아내기
    # a 번 노드에서 b 번 노드로 가는 비용이 c 라는 의미
    graph[a].append((b,c))
    q=[]
    # 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start]=0
    while q : # 큐가 비어있지 않다면
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now= heapq.heappop(q)
        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시 (이미 최단 거리라면 무시)
        if distance[now] < dist:
                continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost <distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q, (cost, i[0]))

# 다익스트라 알고리즘을 수행
dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n+1):
    # 도달할 수 없는 경우, 무한(INFINITY)라고 출력
    if distance[i]==INF:
        print("INFINITY")
    # 도달할 수 있는 경우 거기를 추력
    else:
        print(distance[i])