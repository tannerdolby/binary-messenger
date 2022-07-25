# Binary Messenger
A binary messenger service for encoding strings to their binary representation and decoding binary strings to the original string.

## Example Usage
If you don't need to run the interactive Messenger Service, then just grab a copy of `BinaryMessenger.java` from the `com.binary.messenger` package and utilize the available utility methods.

```java
BinaryMessenger messenger = new BinaryMessenger();

String s = "hello, world!";
String binaryStr = messenger.wordToBinary(s);
System.out.println(binaryStr);
// 01101000 01100101 01101100 01101100 01101111 00101100 00100000 01110111 01101111 01110010 01101100 01100100 00100001
System.out.println(messenger.decodeBinaryWord(binaryStr));
// hello, world!
```

## Messenger Service Demo
Run the messenger service `java MessengerService.java`:

```text
Welcome to the Binary Messenger!
1. Type 'encode' to encode a string into its binary representation:
2. Type 'decode' to decode a binary string:
3. Type 'quit' to stop
encode
Enter string to be encoded:
secret message
01110011 01100101 01100011 01110010 01100101 01110100 00100000 01101101 01100101 01110011 01110011 01100001 01100111 01100101
1. Type 'encode' to encode a string into its binary representation:
2. Type 'decode' to decode a binary string:
3. Type 'quit' to stop
decode
Enter binary string to be decoded:
01110011 01100101 01100011 01110010 01100101 01110100 00100000 01101101 01100101 01110011 01110011 01100001 01100111 01100101
secret message
1. Type 'encode' to encode a string into its binary representation:
2. Type 'decode' to decode a binary string:
3. Type 'quit' to stop
quit
Shutting down messenger service. Thanks for stopping by!
```