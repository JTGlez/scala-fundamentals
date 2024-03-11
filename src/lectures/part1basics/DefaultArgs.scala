
object DefaultArgs extends App {

    // First, we start with the tail-recursive factorial function
    // * We can define default values for the params if we use mostly the same value in one or more args
    def trFact(n: Int, acc: Int = 1): Int = {
        if (n <= 1) acc
        else trFact(n - 1, n * acc)
    }

    val fact10 = trFact(10)

    // 
    def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture")
    // savePicture(800, 600) Invalid call: the compiler will think that we are sending the first param as the format
    savePicture() // If we have default values for every param, then the compiler won't complain
    // * But, If we want to just specify one arg that is not the first one, we can name the arguments
    savePicture(width = 800) // This will use ("jpg", 800, 1080)

    //* With naming parameters, we can even define them in a different order
    savePicture(height = 600, width = 800, format = "bmp") 


  
}
