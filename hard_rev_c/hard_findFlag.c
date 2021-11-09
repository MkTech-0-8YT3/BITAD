#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void initKeyArray(char *key_buff) {
	int key_chars[] = {61,68,79,60,63,90,109,96,113,90,75,77,74};
	int key_len = sizeof(key_chars)/sizeof(int);
	char *tmpBuffer = malloc(key_len);
	for(int i = 0; i < key_len; i++) {
		tmpBuffer[i] = (char) (key_chars[i]+5);
	}
	tmpBuffer[key_len] = '\0';
	strlcpy(key_buff, tmpBuffer, key_len +1);
	if(strlen(key_buff) > key_len) {
		key_buff[key_len] = '\0';
	}
	free(tmpBuffer);
}
void printFlag() {
	int flag_chars[] = {64,81,67,120,63,46,52,62,65,92,79,48,83,92,33,72,46,73,73,48,79,87,122};
	int flag_len = sizeof(flag_chars)/sizeof(int);
	char *flagBuffer = malloc(flag_len);
	for(int i = 0; i < flag_len; i++) {
		flagBuffer[i] = (char) (flag_chars[i]+3);
	}
	flagBuffer[flag_len] = '\0';
	printf(flagBuffer);
	free(flagBuffer);
}

void printArray(char *arr) {
	for(int i = 0; i < strlen(arr); i++) {
		printf("%d",arr[i]);
	}
	printf("\n");
}

int main(int argc, char **argv) {
	if(argc != 2) {
		printf("Usage: %s <key>", argv[0]);
		return -1;
	}
	char key[] = "FindOtherWay!!!";
	initKeyArray(key);

	//printf("%s\n", key);
	//printf("%s\n", argv[1]);
	//printArray(argv[1]);
	//printArray(key);
	//printf("%d",sizeof(key));
	//printf("%d",strlen(argv[1]));
	//printf("%d", strlen(key));
	//printf("\nstrcpy returned: %d", strcpy("BITAD", argv[1]));

	if(strlen(argv[1]) != strlen(key)) {
		printf("Incorrect key!");
		return 0;
	}

	if(strncmp(key, argv[1], strlen(key)) == 0) {
		printf("Correct key!\nFlag: ");
		printFlag();
	} else {
		printf("Incorrect key!");
	}
	return 0;
}
