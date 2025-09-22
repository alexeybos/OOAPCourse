Java
```java
class Expression {
    @Override
    public String toString() {
        return "some expression";
    }  
}

class SimpleExpression extends Expression {
    @Override
    public String toString() {
        return "some simple expression";
    }
}

class ComplexExpression extends SimpleExpression {
    @Override
    public String toString() {
        return "some complex expression";
    }
}

...

Expression expression = new ComplexExpression();
System.out.println(expression); // "some complex expression"

```
Python
```declarative
# вычисление хэш-функции
class IHasher(ABC):
@abstractmethod
def hash_fun(self, key: str) -> int:
pass

class SumHasher(IHasher):
def hash_fun(self, key: str) -> int:
acc = 0
for c in key:
code = ord(c)
acc = acc + code
return acc

class DJB2Hasher(IHasher):
def hash_fun(self, key: str) -> int:
# djb2
acc = 5381
for c in key:
code = ord(c)
acc = (acc << 5) + acc + code
return acc % 4294967296

hasher: IHasher = SumHasher()
h = hasher.hash_fun("skillsmart") # 1094
print(h)
hasher = DJB2Hasher()
h = hasher.hash_fun("skillsmart") # 458085675
print(h)
```

