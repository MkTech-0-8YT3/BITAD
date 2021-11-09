import crypt
import sys

if len(sys.argv) != 3:
    print("Usage: %s <PassClearText> <Salt>\n Hash example: $6$NJkrCxErD9Otg6KZ" % sys.argv[0])
    sys.exit(-1)

print("Pass: %s" % sys.argv[1])
print("Salt: %s" % sys.argv[2])

hashed_pass = crypt.crypt(str(sys.argv[1]), str(sys.argv[2]))
print("Hash: %s" % hashed_pass)
