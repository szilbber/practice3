package lesson4;

@DeprecatedEx(message = "Используйте NewClass вместо этого")
class OldClass {
    @DeprecatedEx(message = "Используйте newMethod()")
    public void oldMethod() {
        System.out.println("Старый метод");
    }
}