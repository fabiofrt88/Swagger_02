package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping(value = "")
    public String welcomeMathMsg(){
        return "Welcome in math";
    }

    @GetMapping(value = "division-info")
    @ApiOperation(value = "Division", notes = "This method return detail of division")
    public ArithmeticOperation division(){
        return new ArithmeticOperation("Division",2,"The division of number", new String[]{"Not Commutative", "Not Associative"});
    }

    @GetMapping(value = "multiplication")
    @ApiOperation(value = "Multiplication", notes = "This method return multiplication of two param")
    public int multiplication(@RequestParam int param1, @RequestParam int param2){
        return param1 * param2;
    }

    @GetMapping(value = "/square/{n}")
    @ApiOperation(value = "Square", notes = "This method return square of param")
    public Integer square(@PathVariable (required = false, value = "n") Integer n){
        Integer squareResult = n * n;
        return squareResult;
    }
}