import crypt
import sys
import argparse

def get_wordlist_content(wordlist):
    with open(wordlist) as f:
        return f.read()

def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('-x', '--hash', help='Hash to crack', required=True)
    parser.add_argument('-w', '--wordlist', help='Wordlist', required=True)
    return parser.parse_args()

def retreive_salt(full_hash):
    pass_split = full_hash.split('$')
    return '$%s$%s' % (pass_split[1], pass_split[2])

def crack_pass(hash_to_crack, salt, wordlist):
    for passwd in get_wordlist_content(wordlist).split():
        processed_hash = crypt.crypt(str(passwd), salt)
        #TODO: Create hash with i
        print("Hash: %s\n pass: %s" % (processed_hash, passwd))
        if hash_to_crack == processed_hash:
            print("Found match! \n Password in cleartext: %s" % str(passwd))
            break

def main():
    args = parse_args()
    salt = retreive_salt(args.hash)
    crack_pass(args.hash, salt, args.wordlist)

if __name__ == "__main__":
    main()
