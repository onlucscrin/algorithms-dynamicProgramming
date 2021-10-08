package org.algorithms.dynamicprogramming.fibonacciProblems;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v2/dp/fibonacci")
public class FibonacciProblemController2 {
    private FibonaciProblemService2 fibonaciProblemService;

    public FibonacciProblemController2(FibonaciProblemService2 fibonaciProblemService){
        this.fibonaciProblemService = fibonaciProblemService;
    }

    @GetMapping(path = "/fibSeries/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity solveFibSeries(@PathVariable int n){
        try{
            int result = this.fibonaciProblemService.calculateFibonacci(n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/countWays/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity solveCountWays(@PathVariable int n){
        try{
            int result = this.fibonaciProblemService.countWays(n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/staircase/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity solveStairCaseWays(@PathVariable int n){
        try{
            int result = this.fibonaciProblemService.countStaircase(n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/minJumps", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity countMinJumps(@RequestBody int jumps[]){
        try{
            int result = this.fibonaciProblemService.countMinJumps(jumps);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/minFeeJumps/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findMinFee(@RequestBody int jumps[], @PathVariable int n){
        try{
            int result = this.fibonaciProblemService.findMinFee(jumps, n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/findMaxSteal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity maxloot(@RequestBody int loots[]){
        try{
            int result = this.fibonaciProblemService.findMaxSteal(loots);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
//    @GetMapping(path = "/countWaysBUP/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity solveCountWaysBup(@PathVariable int n){
//        try{
//            int result = this.fibonaciProblemService.countStaircase(n);
//            return ResponseEntity.ok(result);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//    @GetMapping(path = "/numberFactor/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity solveNumberFactor(@PathVariable int n){
//        try{
//            int result = this.fibonaciProblemService.numberFactorTUP(n);
//            return ResponseEntity.ok(result);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//    @GetMapping(path = "/numberFactorBUP/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity solveNumberFactorBUP(@PathVariable int n){
//        try{
//            int result = this.fibonaciProblemService.numberFactorBUP(n);
//            return ResponseEntity.ok(result);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//    @GetMapping(path = "/countMinJumps", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity countMinJumps(@RequestBody int[] jumps){
//        try{
//            int result = this.fibonaciProblemService.countMinJumps(jumps);
//            return ResponseEntity.ok(result);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//    @GetMapping(path = "/minFeesJump/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity minFeesJump(@RequestBody int[] fees, @PathVariable int n){
//        try{
//            int result = this.fibonaciProblemService.countJumpFees(fees, n);
//            return ResponseEntity.ok(result);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//    @GetMapping(path = "/houseTheif", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity houseTheif(@RequestBody int[] wealth){
//        try{
//            int result = this.fibonaciProblemService.houseTheif(wealth);
//            return ResponseEntity.ok(result);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//    @GetMapping(path = "/houseTheifBUP", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity houseTheifBUP(@RequestBody int[] wealth){
//        try{
//            int result = this.fibonaciProblemService.houseTheifBUP(wealth);
//            return ResponseEntity.ok(result);
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().build();
//        }
//    }

}
