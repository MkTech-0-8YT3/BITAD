import crypt
import sys

if len(sys.argv) != 2:
    print("Usage: %s <PassClearText>" % sys.argv[0])
    sys.exit(-1)

print("Pass: %s" % sys.argv[1])

salt = crypt.mksalt()
hashed_pass = crypt.crypt(str(sys.argv[1]), salt)
print("Salt: %s" % salt)
print("Hash: %s" % hashed_pass)
