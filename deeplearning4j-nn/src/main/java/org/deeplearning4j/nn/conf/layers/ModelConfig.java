package org.deeplearning4j.nn.conf.layers;

import lombok.Data;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.api.OptimizationConfig;
import org.deeplearning4j.nn.conf.stepfunctions.StepFunction;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class ModelConfig extends Layer implements OptimizationConfig {

    //batch size: primarily used for conv nets. Will be reinforced if set.
    protected boolean miniBatch = true;
    //number of line search iterations
    protected int maxNumLineSearchIterations;
    protected long seed;
    protected OptimizationAlgorithm optimizationAlgo;
    protected StepFunction stepFunction;
    //minimize or maximize objective
    protected boolean minimize = true;

    //Counter for the number of parameter updates so far for this layer.
    //Note that this is only used for pretrain layers (RBM, VAE) - MultiLayerConfiguration and ComputationGraphConfiguration
    //contain counters for standard backprop training.
    // This is important for learning rate schedules, for example, and is stored here to ensure it is persisted
    // for Spark and model serialization
    protected int iterationCount = 0;

    //Counter for the number of epochs completed so far. Used for per-epoch schedules
    protected int epochCount = 0;

}