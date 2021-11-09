#include <stdio.h>
#include <string.h>

int main(int argc, char **argv) {
	if(argc == 1) {
		printf("Usage: %s <key>", argv[0]);
		return -1;
	}
	char flag[] = "CTF{R3v3r$3_3N1n33R1nG_1$_4w3s0m3!}";
	char key[] = "B1T4D_R3V3rS3r_2o21";

	if(strcmp(key, argv[1]) == 0) {
		printf("Correct key!\nFlag: %s", flag);
	} else {
		printf("Incorrect key!");
	}
	return 0;
}

