package org.algorithms.dynamicprogramming.fibonacciProblems;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/dp/fibonacci")
public class FibonacciProblemController {
    private FibonaciProblemService fibonaciProblemService;

    public FibonacciProblemController(FibonaciProblemService fibonaciProblemService){
        this.fibonaciProblemService = fibonaciProblemService;
    }

    @GetMapping(path = "/fibSeries/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity solveFibSeries(@PathVariable int n){
        try{
            int result = this.fibonaciProblemService.solveFibSeriesBUP(n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/countWays/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity solveCountWays(@PathVariable int n){
        try{
            int result = this.fibonaciProblemService.solveCountWays(n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/countWaysBUP/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity solveCountWaysBup(@PathVariable int n){
        try{
            int result = this.fibonaciProblemService.solveCountWaysBup(n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/numberFactor/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity solveNumberFactor(@PathVariable int n){
        try{
            int result = this.fibonaciProblemService.numberFactorTUP(n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/numberFactorBUP/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity solveNumberFactorBUP(@PathVariable int n){
        try{
            int result = this.fibonaciProblemService.numberFactorBUP(n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/countMinJumps", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity countMinJumps(@RequestBody int[] jumps){
        try{
            int result = this.fibonaciProblemService.countMinJumps(jumps);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/minFeesJump/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity minFeesJump(@RequestBody int[] fees, @PathVariable int n){
        try{
            int result = this.fibonaciProblemService.countJumpFees(fees, n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/houseTheif", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity houseTheif(@RequestBody int[] wealth){
        try{
            int result = this.fibonaciProblemService.houseTheif(wealth);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(path = "/houseTheifBUP", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity houseTheifBUP(@RequestBody int[] wealth){
        try{
            int result = this.fibonaciProblemService.houseTheifBUP(wealth);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
