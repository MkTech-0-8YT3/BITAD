import crypt
import sys
import argparse

def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('-x', '--hash', help='Hash to crack', required=True)
    return parser.parse_args()

#TODO: Retreive salt from base hash
#Tip: salt chars are 22 characters after id and computation cost

def retreive_salt(full_hash):
    pass_split = full_hash.split('$')
    return '$%s$%s' % (pass_split[1], pass_split[2])

def crack_pass(hash_to_crack, salt):
    for i in range(1, 1000):
        processed_hash = crypt.crypt(str(i), salt)
        #TODO: Create hash with i
        print("Hash: %s\n pass: %s" % (processed_hash, i))
        if hash_to_crack == processed_hash:
            print("Found match! \n Password in cleartext: %s" % str(i))
            break

def main():
    args = parse_args()
    salt = retreive_salt(args.hash)
    crack_pass(args.hash, salt)

if __name__ == "__main__":
    main()

