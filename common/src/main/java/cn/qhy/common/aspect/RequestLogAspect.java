package cn.qhy.common.aspect;


/**
 * api请求日志记录
 *
 * @author qhy
 */
/*
@Slf4j
@Aspect
@Component
public class RequestLogAspect {

    */
/**
     * 监控执行时间阈值
     *//*

    private static final long EXECUTE_TIME_THRESHOLD = 3000;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Around("execution(public * cn.qhy.*.web..*Controller.*(..))")
    public Object aroundRequest(ProceedingJoinPoint invocation) throws Throwable {

        // 记录请求参数信息
        HttpServletRequest request = ServletUtils.getRequest();
        if ((contextPath + "/error").equals(request.getRequestURI())) {
            return invocation.proceed();
        }
        String requestUri = request.getRequestURI().replaceFirst(contextPath, "");
        String requestMethod = request.getMethod();
        String username = Optional.ofNullable(ShiroUtils.getUserInfo()).map(User::getUsername).orElse("anonymous");
        String descInfo = this.logParam(invocation, username, requestUri, requestMethod);

        // 执行原有逻辑
        long start = System.currentTimeMillis();
        Object result = invocation.proceed();

        // 输出执行耗时
        String ipAddr = IpUtils.getIpAddr(ServletUtils.getRequest());
        log.info("用户[{}][{}] <------ 【{}】[{}]【{}】，处理耗时：{}ms", username, ipAddr,
                requestUri, requestMethod, descInfo,
                System.currentTimeMillis() - start);

        return result;
    }

    @Around("execution(public * com.javaweb.*.service.impl..*ServiceImpl.*(..))")
    public Object aroundServiceImpl(ProceedingJoinPoint invocation) throws Throwable {

        long start = System.currentTimeMillis();

        Object result = invocation.proceed();

        long executeMs = System.currentTimeMillis() - start;
        if (executeMs > EXECUTE_TIME_THRESHOLD) {
            HttpServletRequest request = ServletUtils.getRequest();
            if (null == request) {
                return result;
            }
            String ipAddr = IpUtils.getIpAddr(request);
            log.warn("用户[{}][{}] 请求 【{}】时，【{}.{}】执行时间过久：【{}ms】--------------------",
                    Optional.ofNullable(ShiroUtils.getUserInfo()).map(User::getUsername).orElse("anonymous"),
                    ipAddr,
                    request.getRequestURI().replaceFirst(contextPath, ""),
                    invocation.getTarget().getClass().getSimpleName(),
                    invocation.getSignature().getName(),
                    executeMs);
        }
        return result;
    }

    private String logParam(ProceedingJoinPoint invocation, String username, String requestUri, String requestMethod) {

        // 打印参数
        Object[] methodArgs = invocation.getArgs();
        List<Object> argJsonList = new ArrayList<>();
        for (Object methodArg : methodArgs) {
            if (methodArg instanceof MultipartFile) {
                argJsonList.add("文件/图片上传");
                continue;
            } else if (this.isWrapper(methodArg)) {
                argJsonList.add("wrapper");
                continue;
            }

            Object object = methodArg instanceof byte[] ? new String(((byte[]) methodArg)) : JSON.toJSON(methodArg);
            argJsonList.add(object);
        }

        // 获取方法参数名称
        MethodSignature signature = (MethodSignature) invocation.getSignature();
        // 参数名
        List<String> fieldNames = Arrays.asList(signature.getParameterNames());
        // 拼接参数名和参数值
        Iterator<Object> iterator = argJsonList.iterator();
        StringBuilder sb = new StringBuilder();
        fieldNames.forEach(fn -> sb.append(fn).append("=").append(iterator.next()).append(", "));
        // SpringDoc注解信息
        Tag tagInfo = invocation.getTarget().getClass().getAnnotation(Tag.class);
        String tagDesc = Optional.ofNullable(tagInfo).map(Tag::name).orElse(invocation.getTarget().getClass().getSimpleName());
        Operation operationInfo = signature.getMethod().getAnnotation(Operation.class);
        String apiDesc = Optional.ofNullable(operationInfo).map(Operation::summary).orElse(signature.getMethod().getName());
        String descInfo = String.join(".", tagDesc, apiDesc);
        String ipAddr = IpUtils.getIpAddr(ServletUtils.getRequest());
        log.info("用户[{}][{}] ------> 【{}】[{}]【{}】，参数：{}", username, ipAddr,
                requestUri, requestMethod, descInfo,
                sb.toString().replaceAll("\"([^\"|\"]*)\":", "$1="));

        return descInfo;
    }

    private boolean isWrapper(Object obj) {
        return obj instanceof HttpServletRequest
                || obj instanceof HttpServletResponse
                || obj instanceof HttpSession;
    }

}
*/
