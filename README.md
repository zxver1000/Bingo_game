# Bingo_game


- Java Swing을 이용한 간단한 Bingo Game 입니다.
- 3~10 까지 N x N 크기의 빙고판을 생성할수있습니다.
- 사용자가 빙고판에 있는 영어단어를 입력하면 그 즉시 컴퓨터가 알고리즘에 따라 고를 단어를 정합니다.
- 턴이 끝났을때 사용자와 컴퓨터의 빙고 개수를 비교하여 더 많은 쪽이 승리합니다


<h4>Algorithm</h4>



---



<img src="https://user-images.githubusercontent.com/78923992/207078779-c4dbefe7-0696-4c0b-b8e5-5b9c915fdafc.png"  width="300" height="300"/>
- Computer_board가 (0,0)과 (1,1)이 체크 되어있을 때를 가정합니다
- (0,0)과 빙고가 될 수 있는 라인에 있는 점들은 모두 점수를 부여합니다
- (0,0)과 빙고가 될 수 있는 라인은 세라인이 가능하므로




<img src="https://user-images.githubusercontent.com/78923992/207078843-5fd6da05-f122-4ab2-b77e-3442f3ac50e4.png"  width="300" height="300">



- 세라인에 있는 모든 점들에게 점수를 부여합니다




<img src="https://user-images.githubusercontent.com/78923992/207078873-a3db354a-7ebd-4cd5-bb7d-df7792588643.png"  width="300" height="300"/>



- 이렇게 각 점마다 O표시가됬다면 그 점이 빙고가 될 수 있는 라인에 존재하는 점들에게 점수를 부여합니다




<img src="https://user-images.githubusercontent.com/78923992/207078900-267c94af-d557-4ab6-a1b2-c9477228a4c0.png"  width="300" height="300"/>



- 모든 점에게 점수를 부여하고 체크가 되지않고 max점수를 가진 점들만 확인 합니다
- max점수를 가진 점마다 Row,Column,Diagonal에 O표시가 몇 개 있는지 확인하고 Row,Column,Diagonal 개수의 Max값을 구합니다.



<img src="https://user-images.githubusercontent.com/78923992/207078929-8199db8b-e850-41ee-86bd-1af250fe9cfa.png"  width="300" height="300"/>



- 다 구했다면 Max를 가진 점을 컴퓨터가 이 턴에 고르도록 알고리즘을 구현하였습니다.




<img src="https://user-images.githubusercontent.com/78923992/207078958-9dcae318-4040-4bda-ae42-2c3ddc43ce3f.png"  width="300" height="300"/>










<h3>Result</h3>


--
![Animation](https://user-images.githubusercontent.com/78923992/207081789-16ca7bf7-fd45-4f86-9d66-8e0d8293cb51.gif)






