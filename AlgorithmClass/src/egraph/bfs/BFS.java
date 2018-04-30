package egraph.bfs;

import java.util.*;
public class BFS {
	int N;  // 그래프 정점의 수
	List<Edge>[] graph;
	private boolean[ ] visited;	 // BFS 수행 중 방문한 정점의 원소를 true로 만든다.
	
	public BFS(List<Edge>[] adjList) { // 생성자
		N = adjList.length;
		graph = adjList;
		visited = new boolean [N];
		for (int i = 0; i < N; i++) visited[i] = false;   // 배열 초기화
		for (int i = 0; i < N; i++) if (!visited[i]) bfs(i);
	}
	
	//*****************************************************
	private void bfs(int i) {
		
		
		
		
	}
}

