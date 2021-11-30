hepsi: derle calistir

derle:
	gcc -I ./include/ -o ./lib/Random.o -c ./src/Random.c
	gcc -I ./include/ -o ./lib/RastgeleKisi.o -c ./src/RastgeleKisi.c
	gcc -I ./include/ -o ./bin/Test ./lib/RastgeleKisi.o ./lib/Random.o ./src/test.c

calistir:
	./bin/test