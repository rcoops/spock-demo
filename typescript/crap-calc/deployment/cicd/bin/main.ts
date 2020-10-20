#!/usr/bin/env node
import * as cdk from '@aws-cdk/core';
import {NpmLibraryPipeline} from '@upside/cicd-pipelines';

export class CicdStack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    new NpmLibraryPipeline(this, 'Pipeline', {
      projectName: 'spock-demo-crap-calc',
      projectPath: 'typescript/crap-calc',
      repository: {
        owner: 'upside-energy',
        name: 'spock-demo'
      },
      githooks: true
    });
  }
}

const app = new cdk.App();
new CicdStack(app, 'build-account', {
    stackName: 'spock-demo-crap-calc-pipeline',
    env: {
        account: '954120958147',
        region: 'eu-west-1'
    }
});
