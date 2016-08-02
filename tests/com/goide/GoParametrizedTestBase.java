/*
 * Copyright 2013-2016 Sergey Ignatov, Alexander Zolotov, Florin Patan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.goide;

import com.goide.inspections.GoBoolExpressionsInspection;
import com.goide.quickfix.GoQuickFixTestBase;
import com.intellij.testFramework.EdtTestUtil;
import com.intellij.testFramework.TestRunnerUtil;
import com.intellij.util.ThrowableRunnable;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
@SdkAware
public abstract class GoParametrizedTestBase extends GoQuickFixTestBase {

  protected abstract void doTest();

  @Test
  public void test() {
    safeEdt(this::doTest);
  }

  @Before
  @Override
  public void setUp() throws Exception {
    safeEdt(() -> {
      super.setUp();
      myFixture.enableInspections(GoBoolExpressionsInspection.class);
    });
  }

  @SuppressWarnings("TearDownDoesntCallSuperTearDown")
  @After
  @Override
  public void tearDown() {
    safeEdt(super::tearDown);
  }

  private void safeEdt(@NotNull ThrowableRunnable<Throwable> r) {
    if (runInDispatchThread()) {
      TestRunnerUtil.replaceIdeEventQueueSafely();
      EdtTestUtil.runInEdtAndWait(r);
    }
    else {
      try {
        r.run();
      }
      catch (Throwable t) {
        throw new RuntimeException(t);
      }
    }
  }
}